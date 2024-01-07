class EmptyContainer extends HTMLElement {
    constructor() {
        super();
        const shadow = this.attachShadow({mode: 'open'});
        const template = document.createElement('template');

        template.innerHTML = `
            <style>
                div {
                    border: 1px solid black;
                    width: 200px;
                    height: 150px;
                    margin: 20px;
                    text-align: center;
                    /*background-color: gray;*/
                    background-color: snow;
                    border-radius: 20px;
                }
            </style>
            <div>
                <p>Container</p>
            </div>
        `;

        shadow.appendChild(template.content.cloneNode(true));
    }
}

customElements.define('empty-container', EmptyContainer);