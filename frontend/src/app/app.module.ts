import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';

import { HttpClientModule } from "@angular/common/http";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BeneficiarioComponent } from './beneficiario/beneficiario.component';
import { InicioComponent } from './inicio/inicio.component';
import { TabMenuModule } from 'primeng/tabmenu';
import { PlanoComponent } from './plano/plano.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BeneficiarioComponent,
    InicioComponent,
    PlanoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ButtonModule,
    ReactiveFormsModule,
    TabMenuModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
