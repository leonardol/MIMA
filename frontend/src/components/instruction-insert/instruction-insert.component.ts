import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { NgForm } from '@angular/forms';
import { InstructionDTO } from 'src/dto/InstructionDTO';
import { InstructionService } from 'src/services/instruction.service';
import { ParamDTO } from 'src/dto/ParamDTO';

@Component({
  selector: 'app-instruction-insert',
  templateUrl: './instruction-insert.component.html',
  styleUrls: ['./instruction-insert.component.css']
})
export class InstructionInsertComponent implements OnInit {

  public instructionDTO: InstructionDTO;
  private paramDTO: ParamDTO;

  constructor(private router: Router, private instructionService: InstructionService) { }

  ngOnInit() {
    if (sessionStorage.getItem("idTask") == null) {
      this.router.navigateByUrl("taskShow");
    }
    this.instructionDTO = new InstructionDTO(0, 0, "", "", parseInt(sessionStorage.getItem("idTask")));
  }

  insertInstruction(f: NgForm) {
    this.paramDTO = new ParamDTO(sessionStorage.getItem("userLogged"), this.instructionDTO);
    this.instructionService.insertInstruction(this.paramDTO).subscribe((data: any) => {
      if (data != null)
        alert("Inserimento effettuato");
      else
        alert("Inserimento fallito");
      this.router.navigateByUrl("homeUser");
    })

  }

}
