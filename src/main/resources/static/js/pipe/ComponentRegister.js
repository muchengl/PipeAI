class ComponentRegister {
    constructor() {
        this.components = []; // All ModelComponent
        this.componentsMap = new Map();
    }

    addComponent(component){
        this.components.push(component)
        this.componentsMap.set(
            component.cell,
            this.components.length - 1
        )

        for (let i = 0; i < component.dots.length; i++) {
            this.componentsMap.set(
                component.dots[i],
                this.components.length - 1
            )
        }
    }

    getComponent(cell){
        var idx = this.componentsMap.get(cell);
        return this.components[idx];
    }

    deleteComponent(cell){
        var idx = this.componentsMap.get(cell);
        this.componentsMap.delete(cell)
        this.components.splice(idx,1)
    }


    // updateComponent(component){
    //
    // }

}