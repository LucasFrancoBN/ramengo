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
