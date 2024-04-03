const scrolls = document.querySelectorAll(".scroll");

scrolls.forEach((item) =>
  item.addEventListener("click", function () {
    console.log("Hello");
    const element = item.getElementsByClassName("item-scroll")[0];
    if (element.style.height != "0px") {
      element.style.height = 0 + "px";
    } else {
      element.style.height = element.scrollHeight + "px";
    }
  })
);
