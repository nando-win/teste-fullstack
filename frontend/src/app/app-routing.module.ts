import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { BeneficiarioComponent } from './beneficiario/beneficiario.component';
import { InicioComponent } from './inicio/inicio.component';
import { PlanoComponent } from './plano/plano.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'home', component: InicioComponent },
  { path: 'beneficiario', component: BeneficiarioComponent },
  { path: 'plano', component: PlanoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
