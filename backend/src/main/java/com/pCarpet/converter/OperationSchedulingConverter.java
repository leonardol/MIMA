package com.pCarpet.converter;

import java.util.ArrayList;
import java.util.List;

import com.pCarpet.dto.OperationSchedulingDTO;
import com.pCarpet.model.OperationScheduling;
import com.pCarpet.model.Scheduling;
import com.pCarpet.model.Task;

public class OperationSchedulingConverter {

	public static OperationScheduling convertToEntity(OperationSchedulingDTO osdto) {
		OperationScheduling os = null;
		if (osdto != null) {
			os = new OperationScheduling();
			if (osdto.getId() != 0)
				os.setId(osdto.getId());
			os.setOrderTask(osdto.getOrder());
			Task task = new Task();
			task.setId(osdto.getIdTaskFather());
			os.setTaskFather(task);
			task.setId(osdto.getIdTaskChild());
			os.setTaskChild(task);
			Scheduling scheduling = new Scheduling();
			scheduling.setId(osdto.getIdScheduling());
			os.setScheduling(scheduling);
		}
		return os;
	}

	public static OperationSchedulingDTO convertToDto(OperationScheduling os) {
		OperationSchedulingDTO osdto = null;
		if (os != null) {
			osdto = new OperationSchedulingDTO();
			osdto.setId(os.getId());
			osdto.setIdScheduling(os.getScheduling().getId());
			osdto.setIdTaskFather(os.getTaskFather().getId());
			osdto.setIdTaskChild(os.getTaskChild().getId());
			osdto.setOrder(os.getOrderTask());
		}
		return osdto;
	}

	public static List<OperationSchedulingDTO> toListDTO(List<OperationScheduling> list){
		List<OperationSchedulingDTO> listOperationSchedulingDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for(OperationScheduling OperationScheduling : list) {
				listOperationSchedulingDTO.add(OperationSchedulingConverter.convertToDto(OperationScheduling));
			}
		}
		return listOperationSchedulingDTO;
	}
}
