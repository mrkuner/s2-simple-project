/***********************************************************************************
 Funcion:    creaXhr
 Finalidad:  Crea un objeto XMLHttpRequest (que es dependiente del navegador) para
             hacer peticiones AJAX. Esta creacion es dependiente de si el navegador
             es IE (y sus versiones) o si es otro navegador.
***********************************************************************************/
function creaXhr(){
   var xhr ; 
   
   try {
     xhr = new ActiveXObject("Msxml2.XMLHTTP");
   }catch(err) {
   
     try {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
     } catch(err){
        xhr = null;
     }
     
   }
   
   if ( !xhr && typeof XMLHttpRequest != 'undefined' ){
      xhr = new XMLHttpRequest();
   }
   
   return xhr;
}