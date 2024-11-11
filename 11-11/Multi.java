class SharedDara{
    private boolean processed = true;;
    private int number ;
    synchronized void SetNumber(int n){
        this.number= n;
        this.processed=false;
    }
    synchronized void setProcessed(boolean val){
        this.processed=val;
    }
    synchronized int getNumber(){
        return this.number;
    }
    synchronized boolean isProcessed(){
        return this.processed;
    }

}