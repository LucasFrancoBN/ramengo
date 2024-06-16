import { textFormatter } from "../utils/formatter";
import CustomFetch from "../utils/CustomFetch";
import { loadindStructure } from "../utils/loadingStructure";

export default class PlaceOrder {
  brothList;
  proteinList;
  buttonPlaceOrder;
  buttonNewOrder;
  successWrapper;
  imageSuccess;
  descriptionSuccess;
  broth;
  protein;
  activeClass = "active";
  textFormatter;
  customFetch;

  constructor(
    brothList,
    proteinList,
    buttonPlaceOrder,
    buttonNewOrder,
    successWrapper,
    imageSuccess,
    descriptionSuccess,
    wrapperLoading
  ) {
    this.brothList = [...brothList];
    this.proteinList = [...proteinList];
    this.buttonPlaceOrder = buttonPlaceOrder;
    this.buttonNewOrder = buttonNewOrder;
    this.successWrapper = successWrapper;
    this.imageSuccess = imageSuccess;
    this.descriptionSuccess = descriptionSuccess;
    this.textFormatter = textFormatter;
    this.customFetch = new CustomFetch(wrapperLoading, loadindStructure.order);

    this.handleClickPlaceOrder = this.handleClickPlaceOrder.bind(this);
    this.handleClickNewOrder = this.handleClickNewOrder.bind(this);
  }

  validation() {
    return this.broth && this.protein;
  }

  changeSuccessStatus(description, image) {
    this.successWrapper.classList.add(this.activeClass);
    this.successWrapper.ariaHidden = "false";
    this.imageSuccess.src = image;
    this.descriptionSuccess.innerText = description;
  }

  async placingOrder() {
    const { json, response } = await this.customFetch.request(
      "http://localhost:8080/ramengo/orders",
      {
        method: "POST",
        headers: { "Content-Type": "application/json", "x-api-key": "" },
        body: JSON.stringify({ brothId: this.broth, proteinId: this.protein }),
      }
    );
    console.log(
      JSON.stringify({ brothId: this.broth, proteinId: this.protein })
    );
    console.log(json, response);
    if (response?.status !== 201 || !json) {
      alert("We were unable to process your order. Please try again.");
      return;
    }
    this.changeSuccessStatus(json.description, json.image);
  }

  changeButtonStatus() {
    const imgButton = this.buttonPlaceOrder.querySelector("img");
    if (this.validation()) {
      this.buttonPlaceOrder.classList.add("active");
      imgButton.src = "./assets/arrow/active.svg";
    } else {
      this.buttonPlaceOrder.classList.remove("active");
      imgButton.src = "./assets/arrow/inactive.svg";
    }
  }

  changeImage(list, clickedItem) {
    const imgClickedItem = clickedItem.querySelector("img");

    list.forEach((item) => {
      const img = item.querySelector("img");
      img.src = img.dataset.inactive;
    });

    imgClickedItem.src = imgClickedItem.dataset.active;
  }

  selectItem(type, clickedItem) {
    this[type] = clickedItem.dataset.key;
  }

  handleClickNewOrder() {
    this.successWrapper.ariaHidden = "true";
    this.successWrapper.classList.remove("active");
  }

  handleClick(type, list, clickedItem) {
    list.forEach((item) => {
      item.classList.remove(this.activeClass);
    });
    clickedItem.classList.add(this.activeClass);
    this.changeImage(list, clickedItem);
    this.selectItem(type, clickedItem);
    this.changeButtonStatus();
  }

  handleClickPlaceOrder() {
    if (!this.validation()) {
      alert("Do you need select a broth and a protein.");
      return;
    }
    this.placingOrder();
  }

  addEvent() {
    this.brothList.forEach((brothItem, _, a) =>
      brothItem.addEventListener("click", () =>
        this.handleClick("broth", a, brothItem)
      )
    );
    this.proteinList.forEach((proteinItem, _, a) =>
      proteinItem.addEventListener("click", () =>
        this.handleClick("protein", a, proteinItem)
      )
    );
    this.buttonPlaceOrder.addEventListener("click", this.handleClickPlaceOrder);
    this.buttonNewOrder.addEventListener("click", this.handleClickNewOrder);
  }

  init() {
    this.addEvent();
  }
}
