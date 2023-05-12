import { Component, OnInit } from '@angular/core';
import { Beneficiario } from '../interfaces/beneficiario';
import { ListService } from '../services/list.service';

@Component({
  selector: 'app-beneficiario',
  templateUrl: './beneficiario.component.html',
  styleUrls: ['./beneficiario.component.css']
})
export class BeneficiarioComponent implements OnInit {

  beneficiarios: Beneficiario[] = [];

  ngOnInit(): void {
    this.getBeneficiarios();
  }

  constructor(private listService: ListService) {
    this.getBeneficiarios
  }

  getBeneficiarios(): void {
    this.listService.getBeneficiarios().subscribe((beneficiarios) => (this.beneficiarios = beneficiarios))
  }

}
