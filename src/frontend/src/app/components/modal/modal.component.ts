import {Component} from '@angular/core';


@Component({
    selector: 'app-modal',
    templateUrl: 'modal.template.html',
    styleUrls: ['modal.style.css']
})
export class ModalComponent {

    public visible = false;
    public visibleAnimate = false;

    constructor(){}

    public show(): void {
        this.visible = true;
        setTimeout(() => this.visibleAnimate = true, 100);
    }

    public hide(): void {
        this.visibleAnimate = false;
        setTimeout(() => this.visible = false, 300);
    }

    public onContainerClicked(event: MouseEvent): void {
        if ((<HTMLElement>event.target).classList.contains('modal')) {
            this.hide();
        }
    }

}
