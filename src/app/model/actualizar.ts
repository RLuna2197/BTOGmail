export class Actualizar{
        idCorreo: number = 0;
        nombreEmisor: string = '';
        correoEmisor: string = '';
        asunto: string = '';
        mensaje: string = '';
        categoria: boolean = false;
        leido: boolean = false;
        destacado: boolean = false;
        eliminado: boolean = false;
        spam: boolean = false;
        // fecha: Date = new Date();
        fecha: string="";
        correoReceptor: string = '';
    
        constructor() {
            this.idCorreo,
            this.nombreEmisor,
            this.correoEmisor,
            this.asunto,
            this.mensaje,
            this.categoria,
            this.leido,
            this.destacado,
            this.eliminado,
            this.spam,
            this.fecha,
            this.correoReceptor
        }
    }