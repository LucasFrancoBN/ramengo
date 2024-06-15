import { textFormatter } from "../utils/formater";
import { map } from "../utils/map";
import { request } from "../utils/request";

export default class PlaceOrder {
  brothList;
  meatList;
  buttonPlaceOrder;
  broth;
  meat;
  activeClass = "active";
  map;
  textFormatter;
  request;

  constructor(brothList, meatList, buttonPlaceOrder) {
    this.brothList = [...brothList];
    this.meatList = [...meatList];
    this.buttonPlaceOrder = buttonPlaceOrder;
    this.map = map;
    this.textFormatter = textFormatter;
    this.request = request;
  }

  validation() {
    return this.broth && this.meat;
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
      alert("Do you need select a broth and a meat.");
      return;
    }
    this.request("http://localhost:8080/ramengo/broths", {
      headers: { "x-api-key": "" },
    });
  }

  addEvent() {
    this.brothList.forEach((brothItem, _, a) =>
      brothItem.addEventListener("click", () =>
        this.handleClick("broth", a, brothItem)
      )
    );
    this.meatList.forEach((meatItem, _, a) =>
      meatItem.addEventListener("click", () =>
        this.handleClick("meat", a, meatItem)
      )
    );
    this.buttonPlaceOrder.addEventListener("click", () =>
      this.handleClickPlaceOrder()
    );
  }

  init() {
    this.addEvent();
  }
}
