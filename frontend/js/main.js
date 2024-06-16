import CardList from "./CardList/CardsList.js";
import PlaceOrder from "./PlaceOrder/PlaceOrder";

const brothWrapperList = document.querySelector(".broths.cards-list");
const brothWrapperDots = document.querySelector(
  ".broths.cards-list ~ .cards-dots"
);
const brothWrapperLoading = document.querySelector(
  ".broths.cards-list + .loading-cards"
);

const proteinWrapperList = document.querySelector(".protein.cards-list");
const proteinWrapperDots = document.querySelector(
  ".protein.cards-list ~ .cards-dots"
);
const proteinWrapperLoading = document.querySelector(
  ".protein.cards-list + .loading-cards"
);

const buttonPlaceOrder = document.querySelector(".placeorder-wrapper button");
const buttonNewOrder = document.querySelector(".neworder.button");
const successWrapper = document.querySelector(".success");
const imageSuccess = successWrapper?.querySelector(".success-ramen img");
const descriptionSuccess = successWrapper?.querySelector(".success-ramen h1");
const orderWrapperLoading = document.querySelector(".loading-order");

async function initialize() {
  const brothCardList = new CardList(
    brothWrapperList,
    brothWrapperDots,
    "broth",
    brothWrapperLoading
  );
  await brothCardList.init();

  const proteinCardList = new CardList(
    proteinWrapperList,
    proteinWrapperDots,
    "protein",
    proteinWrapperLoading
  );
  await proteinCardList.init();

  const brothList = document.querySelectorAll(".broths.cards-list .cards-card");

  const proteinList = document.querySelectorAll(
    ".protein.cards-list .cards-card"
  );
  const placeOrder = new PlaceOrder(
    brothList,
    proteinList,
    buttonPlaceOrder,
    buttonNewOrder,
    successWrapper,
    imageSuccess,
    descriptionSuccess,
    orderWrapperLoading
  );
  placeOrder.init();
}
initialize();
