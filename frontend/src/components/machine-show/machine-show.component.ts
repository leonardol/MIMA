import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from "@angular/router";
import {MachineDTO} from 'src/dto/MachineDTO';
import {MachineService} from 'src/services/machine.service';
import { UserDTO } from 'src/dto/UserDTO';
import { HttpResponse } from '@angular/common/http';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Subject } from 'rxjs';

declare var $;

@Component({
  selector: 'app-machine-show',
  templateUrl: './machine-show.component.html',
  styleUrls: ['./machine-show.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class MachineShowComponent implements OnInit, OnDestroy {

  public machineDTO: MachineDTO;
  public userDTO: UserDTO;

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<MachineDTO> = new Subject();
  machines: MachineDTO[] = [];
  // We use this trigger because fetching the list of persons can be quite long,
  // thus we ensure the data is fetched before rendering
  

  constructor(private config: NgbModalConfig, private modalService: NgbModal, private machineService: MachineService, private router:  Router) { 
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit() {

    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10
    };

    this.userDTO = JSON.parse(localStorage.getItem("currentUserData")) as UserDTO;
    this.machineDTO = new MachineDTO(null,null,null,this.userDTO.id);

    this.machineService.showMachine(this.userDTO.id).subscribe((response: Array<MachineDTO>) => {
      this.machines = response;
        // Calling the DT trigger to manually render the table
        this.dtTrigger.next();
    })
  }

  ngOnDestroy(): void {
    // Do not forget to unsubscribe the event
    this.dtTrigger.unsubscribe();
  }

  chooseMachine(idMachine: number){
    sessionStorage.setItem("idMachine",JSON.stringify(idMachine));
    alert("Macchinario selezionato");
    this.router.navigateByUrl("machineShow");
  }

  deleteMachine(idMachine: number){

    this.machineService.deleteMachine(idMachine).subscribe((response: HttpResponse<any>) => {   
      location.reload(true);
    })
  }

  open(content) {
    this.modalService.open(content);
  }

  insertMachine(){

    console.log(this.machineDTO);

    this.machineService.insertMachine(this.machineDTO).subscribe((response: MachineDTO) => {
        location.reload(true);
    })
  }

  

}
