import CardList from "./cardsList/CardsList.js";

const brothWrapperList = document.querySelector(".broths.cards-list");
const brothList = document.querySelectorAll(".broths.cards-list .cards-card");
const brothDots = document.querySelectorAll(
  ".broths.cards-list + .cards-dots .cards-dot"
);
const brothCardList = new CardList(brothWrapperList, brothList, brothDots);
brothCardList.init();
