package pl.madejski.model;

public class Client {
		
		private Long clientId;
		private String clientName;
		private String clientSurname;		
		
		public Client(Long clientId, String clientName, String clientSurname){
			this.clientId = clientId;
			this.clientName = clientName;
			this.clientSurname=clientSurname;
		}
		
		public Long getClientId() {
			return clientId;
		}
		
		public void setClientId(Long clientId) {
			this.clientId = clientId;
		}
		
		public String getClientSurname() {
			return clientSurname;
		}
		
		public void setClientSurname(String clientSurname) {
			this.clientSurname = clientSurname;
		}
		
		public String getClientName() {
			return clientName;
		}
		
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
	
	}
