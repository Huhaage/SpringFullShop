// console.log('click')
const cartButtons = document.querySelectorAll('.cart-button');
console.log(cartButtons) 
findButton()
// a tester 
function findButton() {
   
    cartButtons.forEach(button => {
        button.addEventListener('click',cartClick);
    });
}


function cartClick() {
    this.button = this;
    this.button.classList.add('clicked');
    remClick()
}
function remClick() {
    const cartButtons = document.querySelectorAll('.cart-button');
    //console.log(cartButtons)
    cartButtons.forEach(button => {
        setTimeout(() => {
            button.classList.remove('clicked')
        }, 3000);

    })
}
