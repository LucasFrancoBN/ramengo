export default class CardList {
  wrapperList;
  items;
  dots;
  position;
  activeClass = "active";

  constructor(wrapperList, items, dots) {
    this.wrapperList = wrapperList;
    this.items = [...items];
    this.dots = [...dots];
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

  init() {
    if (!this.items.length || !this.dots.length || !this.wrapperList) return;
    this.addEvents();
    this.transition(true);
  }
}
