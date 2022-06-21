
// a tester 
function findButton() {
    const cartButtons = document.querySelectorAll('.cart-button');
    //console.log(cartButtons)
    cartButtons.forEach(button => {
        button.addEventListener('click', this.cartClick);
    });
}

function cartClick() {
    this.button = this;
    this.button.classList.add('clicked');
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
