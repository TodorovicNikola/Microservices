package rs.uns.ac.rs.models;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Document
public class DocumentEntity implements Serializable{
	
	@Id
	private String id;
	
	@Indexed
	private String taskMark;
	private String taskTitle;
	private String taskDescription;
	private String taskCarrier;
	private List<String> taskTeam;
	private List<String> taskTemplates;
	private List<String> taskDeliveredTo;
	private Date taskDueDate;
	private String taskCreatedBy;
	private String userId;
	private String status;
	private Date taskDate;

	

	public DocumentEntity(){
		
	}
	
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getTaskMark() {
		return taskMark;
	}


	public void setTaskMark(String taskMark) {
		this.taskMark = taskMark;
	}


	public DocumentEntity(String id){
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskCarrier() {
		return taskCarrier;
	}

	public void setTaskCarrier(String taskCarrier) {
		this.taskCarrier = taskCarrier;
	}

	public List<String> getTaskTeam() {
		return taskTeam;
	}

	public void setTaskTeam(List<String> taskTeam) {
		this.taskTeam = taskTeam;
	}

	public List<String> getTaskTemplates() {
		return taskTemplates;
	}

	public void setTaskTemplates(List<String> taskTemplates) {
		this.taskTemplates = taskTemplates;
	}

	public List<String> getTaskDeliveredTo() {
		return taskDeliveredTo;
	}

	public void setTaskDeliveredTo(List<String> taskDeliveredTo) {
		this.taskDeliveredTo = taskDeliveredTo;
	}

	public Date getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(Date taskDueDate) {
		this.taskDueDate = taskDueDate;
	}


	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskCreatedBy() {
		return taskCreatedBy;
	}

	public void setTaskCreatedBy(String taskCreatedBy) {
		this.taskCreatedBy = taskCreatedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((taskCarrier == null) ? 0 : taskCarrier.hashCode());
		result = prime * result + ((taskCreatedBy == null) ? 0 : taskCreatedBy.hashCode());
		result = prime * result + ((taskDate == null) ? 0 : taskDate.hashCode());
		result = prime * result + ((taskDeliveredTo == null) ? 0 : taskDeliveredTo.hashCode());
		result = prime * result + ((taskDescription == null) ? 0 : taskDescription.hashCode());
		result = prime * result + ((taskDueDate == null) ? 0 : taskDueDate.hashCode());
		result = prime * result + ((taskMark == null) ? 0 : taskMark.hashCode());
		result = prime * result + ((taskTeam == null) ? 0 : taskTeam.hashCode());
		result = prime * result + ((taskTemplates == null) ? 0 : taskTemplates.hashCode());
		result = prime * result + ((taskTitle == null) ? 0 : taskTitle.hashCode());
		return result;
	}

	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentEntity other = (DocumentEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taskCarrier == null) {
			if (other.taskCarrier != null)
				return false;
		} else if (!taskCarrier.equals(other.taskCarrier))
			return false;
		if (taskCreatedBy == null) {
			if (other.taskCreatedBy != null)
				return false;
		} else if (!taskCreatedBy.equals(other.taskCreatedBy))
			return false;
		if (taskDate == null) {
			if (other.taskDate != null)
				return false;
		} else if (!taskDate.equals(other.taskDate))
			return false;
		if (taskDeliveredTo == null) {
			if (other.taskDeliveredTo != null)
				return false;
		} else if (!taskDeliveredTo.equals(other.taskDeliveredTo))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		if (taskDueDate == null) {
			if (other.taskDueDate != null)
				return false;
		} else if (!taskDueDate.equals(other.taskDueDate))
			return false;
		if (taskMark == null) {
			if (other.taskMark != null)
				return false;
		} else if (!taskMark.equals(other.taskMark))
			return false;
		if (taskTeam == null) {
			if (other.taskTeam != null)
				return false;
		} else if (!taskTeam.equals(other.taskTeam))
			return false;
		if (taskTemplates == null) {
			if (other.taskTemplates != null)
				return false;
		} else if (!taskTemplates.equals(other.taskTemplates))
			return false;
		if (taskTitle == null) {
			if (other.taskTitle != null)
				return false;
		} else if (!taskTitle.equals(other.taskTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentEntity [id=" + id + ", taskMark=" + taskMark + ", taskTitle=" + taskTitle + ", taskDescription="
				+ taskDescription + ", taskCarrier=" + taskCarrier + ", taskTeam=" + taskTeam + ", taskTemplates="
				+ taskTemplates + ", taskDeliveredTo=" + taskDeliveredTo + ", taskDueDate=" + taskDueDate
				+ ", taskCreatedBy=" + taskCreatedBy + ", taskDate=" + taskDate + "]";
	}



	
	
}
