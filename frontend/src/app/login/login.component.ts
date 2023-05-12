import { Component, OnInit } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private _router: Router) { }

  usuario = {
    login: '',
    senha: ''
  }

  usuarioForm!: FormGroup;

  ngOnInit(): void {
    this.usuarioForm = new FormGroup({
      login: new FormControl(this.usuario.login, [Validators.required]),
      senha: new FormControl(this.usuario.senha, [Validators.required])

    })
  }

  get login() { return this.usuarioForm.get('login')! }
  get senha() { return this.usuarioForm.get('senha')! }


  entrar() {
    if (!this.usuarioForm.value.login || !this.usuarioForm.value.senha) {
      alert("Usuário ou senha não informados");
    } else {
      this._router.navigateByUrl('/beneficiario').then(nav => {
        console.log(nav);
      }, err => {
        console.log(err)
      });
    }

  }

}
