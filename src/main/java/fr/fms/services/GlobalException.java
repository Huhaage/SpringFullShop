package fr.fms.services;



public class GlobalException extends RuntimeException {
  
    private String exceptionMsg;

   public GlobalException(String exceptionMsg) {
      this.exceptionMsg = exceptionMsg;
   }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

}
