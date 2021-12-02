import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PlayService } from '../../services/play.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  isSubmitted = false;
  result: string = '';

  constructor(private playService: PlayService) { }

  ngOnInit(): void {  
  }
 
  submitForm(form: NgForm): void {
    this.isSubmitted = true;
    if (!form.valid) {
      console.error("Please select either value");
    } else {
      this.playService.jugar(form.value.selection).subscribe(res => {
        this.result = res.resultadoJuego;
        alert(JSON.stringify(res.resultadoJuego));
      });

    }
  }


}
