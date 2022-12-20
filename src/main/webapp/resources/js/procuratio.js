const openModalButton = document.querySelector("#open-modal");
const closeModalButton = document.querySelector("#close-modal");
const modal = document.querySelector("#modal");
const fade = document.querySelector("#fade");

const toggleModal = () => {
  modal.classList.toggle("hide");
  fade.classList.toggle("hide");
};

// [openModalButton, closeModalButton, fade].forEach((el) => {
//   el.addEventListener("click", () => toggleModal());
// });

const openModal = (modalId) => {
  const modal = document.getElementById(modalId);
  modal.style.display = "block";
};

const closeModal = (modalId) => {
  const modal = document.getElementById(modalId);
  modal.style.display = "none";
};

const addOpenCloseModal = (btnId, modalId) => {
  var btnModal = document.getElementById(btnId);
  btnModal.onclick = function (event) {
    event.preventDefault();
    closeModal(modalId);
  };
};
