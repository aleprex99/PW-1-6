import { Component, ViewChild, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { TabMenu } from 'primeng/tabmenu';
import { Router } from '@angular/router';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
    @ViewChild('tabMenu') tabMenu: TabMenu;

    profileMenuItems: MenuItem[];
    tabMenuItems: MenuItem[];
    activeTabMenuItem: MenuItem;

    constructor(private router: Router) {}

    ngOnInit() {
    this.profileMenuItems = [
        { label: 'Profilo', icon: 'pi pi-address-book', command: () => this.router.navigate(['dashboard', 'profilo']) },
        { label: 'Logout', icon: 'pi pi-sign-out', command: () => this.router.navigate(['logout']) }
    ];

    this.tabMenuItems = [
        { label: 'Polizze', icon: 'pi pi-car', command: () => this.navigateTo('polizze') },
        { label: 'Denuncia sinistro', icon: 'pi pi-file', command: () => this.navigateTo('denunciaSinistro') }
    ];

    this.activeTabMenuItem = this.tabMenuItems[0];

    this.router.navigate(['dashboard', 'polizze']);
    }

    onActiveItemChange(event: MenuItem) {
        this.activeTabMenuItem = event;
    }

    private navigateTo(path: string) {
        this.router.navigate(['dashboard', path]);
    }
}