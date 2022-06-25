// console.log('click')
const cartButtons = document.querySelectorAll('.cart-button');
 
findButton()

function findButton() {
   
    cartButtons.forEach(button => {
        button.addEventListener('click',cartClick);
    });
}


function cartClick() {
    console.log('click')
    this.button = this;
    this.button.classList.add('clicked');
   remClick()
}

function remClick() {
    const cartButtons = document.querySelectorAll('.cart-button');
    cartButtons.forEach(button => {
        setTimeout(() => {
            button.classList.remove('clicked')
        }, 3000);

    })
}
