class ComponentRegister {
    constructor() {
        this.components = [];
        this.componentsMap = new Map();
    }

    addComponent(component){
        this.components.push(component)
        this.componentsMap.set(
            component.cell,component
        )
    }

    updateComponent(component){

    }

}