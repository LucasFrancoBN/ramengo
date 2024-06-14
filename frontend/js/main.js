import CardList from "./cardsList/CardsList";

const brothWrapperList = document.querySelector(".broths.cards-list");
const brothList = document.querySelectorAll(".broths.cards-list .cards-card");
const brothDots = document.querySelectorAll(
  ".broths.cards-list + .cards-dots .cards-dot"
);
const brothCardList = new CardList(brothWrapperList, brothList, brothDots);
brothCardList.init();

const meatWrapperList = document.querySelector(".meat.cards-list");
const meatList = document.querySelectorAll(".meat.cards-list .cards-card");
const meatDots = document.querySelectorAll(
  ".meat.cards-list + .cards-dots .cards-dot"
);
const meatCardList = new CardList(meatWrapperList, meatList, meatDots);
meatCardList.init();
