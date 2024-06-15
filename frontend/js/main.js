import CardList from "./CardsList/CardsList";
import PlaceOrder from "./PlaceOrder/PlaceOrder";

const brothWrapperList = document.querySelector(".broths.cards-list");
const brothList = document.querySelectorAll(".broths.cards-list .cards-card");
const brothDots = document.querySelectorAll(
  ".broths.cards-list + .cards-dots .cards-dot"
);

const meatWrapperList = document.querySelector(".meat.cards-list");
const meatList = document.querySelectorAll(".meat.cards-list .cards-card");
const meatDots = document.querySelectorAll(
  ".meat.cards-list + .cards-dots .cards-dot"
);

const buttonPlaceOrder = document.querySelector(".placeorder-wrapper button");

const brothCardList = new CardList(brothWrapperList, brothList, brothDots);
brothCardList.init();

const meatCardList = new CardList(meatWrapperList, meatList, meatDots);
meatCardList.init();

const placeOrder = new PlaceOrder(brothList, meatList, buttonPlaceOrder);
placeOrder.init();
