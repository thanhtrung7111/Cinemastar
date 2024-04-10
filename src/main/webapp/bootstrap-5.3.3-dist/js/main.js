const scrolls = document.querySelectorAll(".scroll");

scrolls.forEach((item) =>
	item.addEventListener("click", function() {
		console.log("Hello");
		const element = item.getElementsByClassName("item-scroll")[0];
		if (element.style.height != "0px") {
			element.style.height = 0 + "px";
		} else {
			element.style.height = element.scrollHeight + "px";
		}
	})
);

const ghes = document.querySelectorAll(".checkghe");
ghes.forEach(item => {
	item.addEventListener('click', function() {
		if (item.classList.contains("checkghe-active")) {
			item.classList.remove("checkghe-active");
			item.style.backgroundColor = "#FFFFFF ";
			item.style.color = "#5c5c5c";
		} else {
			item.classList.add("checkghe-active");
			item.style.backgroundColor = "#730f0f ";
			item.style.color = "#FFFFFF";
		}

	})
})

const checksuats = document.querySelectorAll(".checksuat");
checksuats.forEach(item => {
	item.addEventListener('click', function() {
		console.log("hello");
		checksuats.forEach(ite => {
			ite.style.backgroundColor = "#ffffff";
			ite.style.color = "#5c5c5c";
		})
		item.style.backgroundColor = "#730f0f";
		item.style.color = "#ffffff";
	})
})
