export default class CustomFetch {
  loadingWrapper;
  loadingStructure;
  activeClass = "active";

  constructor(loadingWrapper, loadingStructure) {
    this.loadingWrapper = loadingWrapper;
    this.loadingStructure = loadingStructure;
  }

  removeLoading() {
    this.loadingWrapper.innerHTML = "";
    this.loadingWrapper.classList.remove(this.activeClass);
  }

  activeLoading() {
    this.loadingWrapper.innerHTML = this.loadingStructure;
    this.loadingWrapper.classList.add(this.activeClass);
  }

  async request(url, options) {
    let response, json;
    try {
      this.activeLoading();
      response = await fetch(url, options);
      json = await response.json();
    } catch (e) {
      json = null;
      console.error(e);
    } finally {
      this.removeLoading();
      return { response, json };
    }
  }
}

export async function request(url, options) {
  let response, json;
  try {
    response = await fetch(url, options);
    json = await response.json();
  } catch (e) {
    json = null;
    console.error(e);
  } finally {
    return { response, json };
  }
}
