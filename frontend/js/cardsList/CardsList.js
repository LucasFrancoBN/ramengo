import { request } from "../utils/request";

export default class CardList {
  wrapperList;
  items;
  wrapperDots;
  dots;
  type;
  position;
  activeClass = "active";
  request;

  constructor(wrapperList, wrapperDots, type) {
    this.wrapperList = wrapperList;
    this.wrapperDots = wrapperDots;
    this.type = type;
    this.request = request;
  }

  setDots(dots) {
    this.dots = dots;
  }

  setItem(items) {
    this.items = items;
  }

  fillDots(lengthItems) {
    this.wrapperDots.innerHTML = `${Array.from({ length: lengthItems })
      .map(
        (_, i) => `
        <span class="cards-dot ${i === 0 ? this.activeClass : ""}"></span>
      `
      )
      .join("")}`;
    const dots = this.wrapperDots.querySelectorAll(".cards-dot");
    this.setDots(dots);
  }

  fillCards(json) {
    this.wrapperList.innerHTML = `${json
      .map(
        (item) => `
          <li class="cards-card shadow p-40" data-key="${item.id}" >
          <figure class="mb-14">
            <img src="${item.imageInactive}" alt="${item.name}" data-active="${item.imageActive}" data-inactive="${item.imageInactive}">
          </figure>
          <h2 class="font-md-black color-blue mb-10">${item.name}</h2>
          <p class="font-sm-medium mb-36">${item.description} </p>
          <p class="price font-md-black color-orange">US$${item.price}</p>
        </li>
      `
      )
      .join("")}`;
    const items = this.wrapperList.querySelectorAll(".cards-card");
    this.setItem(items);
  }

  async fetchData(type) {
    const { json, response } = await request(
      `http://localhost:8080/ramengo/${type}s`,
      {
        headers: { "x-api-key": "" },
      }
    );
    if (response.status !== 200 || json === null) {
      alert("Unable to load data. Please reload the page.");
      return;
    }
    this.fillCards(json);
    this.fillDots(json.length);
  }

  transition(active) {
    this.wrapperList.style.transition = active ? "transform .3s" : "";
  }

  calcOfMove(dotIndex) {
    const item = this.items[dotIndex];
    const itemRect = item.getBoundingClientRect();
    const wrapperRect = this.wrapperList.getBoundingClientRect();

    const itemOffsetLeft = itemRect.left - wrapperRect.left;
    const wrapperCenter = wrapperRect.width / 2;
    const itemCenter = itemOffsetLeft + itemRect.width / 2;

    const moveDistance = wrapperCenter - itemCenter;

    return moveDistance;
  }

  changeItemFocus(dotIndex) {
    this.dots.forEach((dot) => {
      dot.classList.remove(this.activeClass);
    });
    this.dots[dotIndex].classList.add(this.activeClass);

    this.wrapperList.style.transform = `translateX(${this.calcOfMove(
      dotIndex
    )}px)`;
  }

  addEvents() {
    this.dots.forEach((dot, index) => {
      dot.addEventListener("click", () => this.changeItemFocus(index));
    });
  }

  async init() {
    if (!this.wrapperList || !this.wrapperDots || !this.type) return;
    await this.fetchData(this.type);
    this.addEvents();
    this.transition(true);
  }
}
