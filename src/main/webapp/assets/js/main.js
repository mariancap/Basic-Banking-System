const hamburger = document.querySelector(".hamburger-navbar");
        hamburger.onclick = function () {
            const navBar = document.querySelector(".navbar");
            navBar.classList.toggle("active");
        }