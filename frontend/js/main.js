import CardList from "./CardsList/CardsList";
import PlaceOrder from "./PlaceOrder/PlaceOrder";

const brothWrapperList = document.querySelector(".broths.cards-list");
const brothWrapperDots = document.querySelector(
  ".broths.cards-list + .cards-dots"
);
const proteinWrapperList = document.querySelector(".protein.cards-list");
const proteinWrapperDots = document.querySelector(
  ".protein.cards-list + .cards-dots"
);
const brothList = document.querySelectorAll(".broths.cards-list .cards-card");

const proteinList = document.querySelectorAll(
  ".protein.cards-list .cards-card"
);

async function initialize() {
  const brothCardList = new CardList(
    brothWrapperList,
    brothWrapperDots,
    "broth"
  );
  await brothCardList.init();

  const proteinCardList = new CardList(
    proteinWrapperList,
    proteinWrapperDots,
    "protein"
  );
  await proteinCardList.init();
}
initialize();

// const buttonPlaceOrder = document.querySelector(".placeorder-wrapper button");
// const buttonNewOrder = document.querySelector(".neworder.button");
// const successWrapper = document.querySelector(".success");
// const imageSuccess = successWrapper?.querySelector(".success-ramen img");
// const descriptionSuccess = successWrapper?.querySelector(".success-ramen h1");
