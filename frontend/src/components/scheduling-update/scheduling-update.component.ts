import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SchedulingService } from 'src/services/scheduling.service';
import { NgForm } from '@angular/forms';
import { SchedulingDTO } from 'src/dto/SchedulingDTO';

@Component({
  selector: 'app-scheduling-update',
  templateUrl: './scheduling-update.component.html',
  styleUrls: ['./scheduling-update.component.css']
})
export class SchedulingUpdateComponent implements OnInit {
  public schedulingDTO: SchedulingDTO;

  constructor(private router: Router, private schedulingSerivce: SchedulingService) { }

  ngOnInit() {
    this.schedulingDTO = new SchedulingDTO(parseInt(sessionStorage.getItem("idScheduling")),sessionStorage.getItem("nameScheduling"),new Date(), new Date(),parseInt(sessionStorage.getItem("idMachine")));
  }

  schedulingUpdate(f: NgForm){
    this.schedulingSerivce.insertScheduling(this.schedulingDTO).subscribe((data: any) =>{
      if(data != null)
        alert("Aggiornamento effettuato");
      else
        alert("Aggiornamento fallito");
      this.router.navigateByUrl("homeUser");
    })
  }

}
