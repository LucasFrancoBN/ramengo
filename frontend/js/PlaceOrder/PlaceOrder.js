import { textFormatter } from "../utils/formatter";
import { map } from "../utils/map";
import { request } from "../utils/request";

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
  map = {};
  textFormatter;
  request;

  constructor(
    brothList,
    proteinList,
    buttonPlaceOrder,
    buttonNewOrder,
    successWrapper,
    imageSuccess,
    descriptionSuccess
  ) {
    this.brothList = [...brothList];
    this.proteinList = [...proteinList];
    this.buttonPlaceOrder = buttonPlaceOrder;
    this.buttonNewOrder = buttonNewOrder;
    this.successWrapper = successWrapper;
    this.imageSuccess = imageSuccess;
    this.descriptionSuccess = descriptionSuccess;
    this.map = map;
    this.textFormatter = textFormatter;
    this.request = request;

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
    const { json, response } = await this.request(
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
    const titleClickedItem = clickedItem.querySelector("h2");
    const imgClickedItem = clickedItem.querySelector("img");

    list.forEach((item) => {
      const title = item.querySelector("h2");
      const img = item.querySelector("img");
      img.src = `./assets/${this.textFormatter(title.innerText)}/inactive.svg`;
    });

    imgClickedItem.src = `./assets/${this.textFormatter(
      titleClickedItem.innerText
    )}/active.svg`;
  }

  selectItem(type, clickedItem) {
    const searchedTitle = clickedItem.querySelector("h2");
    const formattedText = this.textFormatter(searchedTitle.innerText);
    this[type] = map[formattedText];
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
