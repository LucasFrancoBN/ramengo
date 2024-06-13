export default class CardList {
  wrapperList;
  items;
  dots;

  constructor(wrapperList, items, dots) {
    this.wrapperList = wrapperList;
    this.items = items;
    this.dots = dots;
    console.log(wrapperList, items, dots);
  }

  changeItemFocus(dotIndex) {
    this.dots.forEach((dot) => {
      dot.classList.remove("active");
    });
    this.dots[dotIndex].classList.add("active");
    this.wrapperList.style.transform = `translateX(-${dotIndex * 360}px)`;
  }

  addEvents() {
    this.dots.forEach((dot, index) => {
      dot.addEventListener("click", () => this.changeItemFocus(index));
    });
  }

  init() {
    if (!this.items.length || !this.dots.length || !this.wrapperList) return;
    this.addEvents();
  }
}
