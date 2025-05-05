import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

import { CardModule } from 'primeng/card';
import { FloatLabelModule } from 'primeng/floatlabel';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { AvatarModule } from 'primeng/avatar';
import { MegaMenuModule } from 'primeng/megamenu';
import { RippleModule } from 'primeng/ripple';
import { TooltipModule } from 'primeng/tooltip';
import { DialogModule } from 'primeng/dialog';
import { ContextMenuModule } from 'primeng/contextmenu';
import { ToastModule } from 'primeng/toast';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ProgressBarModule } from 'primeng/progressbar';
import { SlideMenuModule } from 'primeng/slidemenu';
import { OverlayPanelModule } from 'primeng/overlaypanel';
import { TableModule } from 'primeng/table';
import { CheckboxModule } from 'primeng/checkbox';
import { DropdownModule } from 'primeng/dropdown';
import { MenuModule } from 'primeng/menu';
import { MeterGroupModule } from 'primeng/metergroup';
import { TabMenuModule } from 'primeng/tabmenu';
import { HttpClientModule } from '@angular/common/http';
import { PolizzeComponent } from './pages/dashboard/polizze/polizze.component';
import { PreventiviComponent } from './pages/dashboard/preventivi/preventivi.component';
import { DettaglioPolizzaComponent } from './pages/dashboard/polizze/dettaglio-polizza/dettaglio-polizza.component';
import { SinistriComponent } from './pages/dashboard/polizze/dettaglio-polizza/sinistri/sinistri.component';
import { DenunciaSinistroComponent } from './pages/dashboard/denuncia-sinistro/denuncia-sinistro.component';
import { CalendarModule } from 'primeng/calendar';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    PolizzeComponent,
    PreventiviComponent,
    DettaglioPolizzaComponent,
    SinistriComponent,
    DenunciaSinistroComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    CalendarModule,
    AppRoutingModule,
    CardModule,
    FloatLabelModule,
    InputTextModule,
    PasswordModule,
    ButtonModule,
    AvatarModule,
    DropdownModule,
    MegaMenuModule,
    RippleModule,
    DialogModule,
    TooltipModule,
    MeterGroupModule,
    ContextMenuModule,
    ToastModule,
    MessagesModule,
    MessageModule,
    ProgressBarModule,
    SlideMenuModule,
    MenuModule,
    TabMenuModule,
    OverlayPanelModule,
    TableModule,
    CheckboxModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
