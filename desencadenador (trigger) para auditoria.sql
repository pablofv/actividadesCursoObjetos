create or replace TRIGGER "LEX100MAESTRAS"."AUDITORIA_FIRMA" before insert or update
    on documento_exp for each row
declare
    type columnas_tabla is table of user_tab_columns%ROWTYPE;
    var_columnas columnas_tabla := columnas_tabla();
    nombre_tabla_auditada varchar2(35);
    id_operacion int;

    procedure insertarOld(tipoAccion varchar2, tabla varchar2, columna varchar2, operacion int) is
    /* Procedimiento para insertar el registro old. */
    begin
        insert into audit_documento_exp(ID_AUDIT_DOCUMENTO_EXP, id_operacion, FECHAHORA, TABLADESDE, CAMPOMODIFICADO, tipoaccion, ID_RECURSO_EXP, TIPO_PROYECTO, TIMESTAMP_MODIFICACION, USUARIO_MODIFICACION, TICKET_DESPACHO_AVANZADO, FECHA_ESTADO_DOCUMENTO, INHIBIDO, USUARIO_INHIBICION, ID_SUBTIPO_FALLO, CIERRA_RECURSO, DIGITAL, VERSION, DESPACHO_DESDE_PDF, ID_ESTADO_DOCUMENTO, FECHA_INHIBICION, CONTENT_TYPE, CREADO_MASIVO, UUID, OBSERVACIONES_RES_RECURSO, TIPO_VOTO_RES_RECURSO, TIPO_RES_RECURSO, FOJA_VUELTA, ID_OFICINA, ID_DOCUMENTO_ORIGEN, EVENTOS, ID_FIRMANTE_2, INCORPORADO, ID_ESTADO_EXPEDIENTE, ID_EXPEDIENTE_ORIGEN, ID_EXPEDIENTE_FUSION, ID_CAMARA, ID_DOCUMENTO_EXP_TMP, ID_CEDULA_EXP_TMP, ID_DOCUMENTO_BANDEJA_TMP, ID_DOCUMENTO_REL_TMP, SENTENCIA, ID_DOCUMENTO_EXP, ID_EXPEDIENTE, ID_MODELO, ID_FIRMANTE, ID_DOCUMENTO_RELACIONADO, ID_CEDULA_EXP, ID_DOCUMENTO_BANDEJA, DESCRIPCION, ORDEN, FIRMA, FECHA_FIRMA, RESERVADO, FOJAS, FOJA_INICIAL, CUERPO, FECHA_GENERACION, RESPONSABLE, COMENTARIOS, TIPO_DOCUMENTO, ESTADO_EDICION, USUARIO_EDICION, FECHA_EDICION, PROYECTO, TIPO_RESOLUCION, CERT_PRUEBA, CERT_PRUEBA_DESCRIPCION,
        TESTIMONIO, ID_DOCUMENT_STORE, STATUS) select S_AUDIT_DOCUMENTO_EXP.nextval, operacion, systimestamp, tabla, columna, tipoAccion, :old.ID_RECURSO_EXP, :old.TIPO_PROYECTO, :old.TIMESTAMP_MODIFICACION, :old.USUARIO_MODIFICACION, :old.TICKET_DESPACHO_AVANZADO, :old.FECHA_ESTADO_DOCUMENTO, :old.INHIBIDO, :old.USUARIO_INHIBICION, :old.ID_SUBTIPO_FALLO, :old.CIERRA_RECURSO, :old.DIGITAL, :old.VERSION, :old.DESPACHO_DESDE_PDF, :old.ID_ESTADO_DOCUMENTO, :old.FECHA_INHIBICION, :old.CONTENT_TYPE, :old.CREADO_MASIVO, :old.UUID, :old.OBSERVACIONES_RES_RECURSO, :old.TIPO_VOTO_RES_RECURSO, :old.TIPO_RES_RECURSO, :old.FOJA_VUELTA, :old.ID_OFICINA, :old.ID_DOCUMENTO_ORIGEN, :old.EVENTOS, :old.ID_FIRMANTE_2, :old.INCORPORADO, :old.ID_ESTADO_EXPEDIENTE, :old.ID_EXPEDIENTE_ORIGEN, :old.ID_EXPEDIENTE_FUSION, :old.ID_CAMARA, :old.ID_DOCUMENTO_EXP_TMP, :old.ID_CEDULA_EXP_TMP, :old.ID_DOCUMENTO_BANDEJA_TMP, :old.ID_DOCUMENTO_REL_TMP, :old.SENTENCIA, :old.ID_DOCUMENTO_EXP, :old.ID_EXPEDIENTE, :old.ID_MODELO, :old.ID_FIRMANTE, :old.ID_DOCUMENTO_RELACIONADO, :old.ID_CEDULA_EXP, :old.ID_DOCUMENTO_BANDEJA, :old.DESCRIPCION, :old.ORDEN,
        :old.FIRMA, :old.FECHA_FIRMA, :old.RESERVADO, :old.FOJAS, :old.FOJA_INICIAL, :old.CUERPO, :old.FECHA_GENERACION, :old.RESPONSABLE, :old.COMENTARIOS, :old.TIPO_DOCUMENTO, :old.ESTADO_EDICION, :old.USUARIO_EDICION, :old.FECHA_EDICION, :old.PROYECTO, :old.TIPO_RESOLUCION, :old.CERT_PRUEBA, :old.CERT_PRUEBA_DESCRIPCION, :old.TESTIMONIO, :old.ID_DOCUMENT_STORE, :old.STATUS from dual;

    end insertarOld;

    procedure insertarNew(tipoAccion varchar2, tabla varchar2, columna varchar2, operacion int) is
    /* Procedimiento para insertar el registro new. */
    begin
        insert into audit_documento_exp(ID_AUDIT_DOCUMENTO_EXP, id_operacion, FECHAHORA, TABLADESDE, CAMPOMODIFICADO, TIPOACCION,
                                                                                                                                ID_DOCUMENTO_EXP,
                                                                                                                                ID_EXPEDIENTE,
                                                                                                                                ID_MODELO,
                                                                                                                                ID_FIRMANTE,
                                                                                                                                ID_DOCUMENTO_RELACIONADO,
                                                                                                                                ID_CEDULA_EXP,
                                                                                                                                ID_DOCUMENTO_BANDEJA,
                                                                                                                                DESCRIPCION,
                                                                                                                                ORDEN,
                                                                                                                                FIRMA,
                                                                                                                                FECHA_FIRMA,
                                                                                                                                RESERVADO,
                                                                                                                                FOJAS,
                                                                                                                                FOJA_INICIAL,
                                                                                                                                CUERPO,
                                                                                                                                FECHA_GENERACION,
                                                                                                                                RESPONSABLE,
                                                                                                                                COMENTARIOS,
                                                                                                                                TIPO_DOCUMENTO,
                                                                                                                                ESTADO_EDICION,
                                                                                                                                USUARIO_EDICION,
                                                                                                                                FECHA_EDICION,
                                                                                                                                PROYECTO,
                                                                                                                                TIPO_RESOLUCION,
                                                                                                                                CERT_PRUEBA,
                                                                                                                                CERT_PRUEBA_DESCRIPCION,
                                                                                                                                TESTIMONIO,
                                                                                                                                ID_DOCUMENT_STORE,
                                                                                                                                STATUS,
                                                                                                                                UUID,
                                                                                                                                OBSERVACIONES_RES_RECURSO,
                                                                                                                                TIPO_VOTO_RES_RECURSO,
                                                                                                                                TIPO_RES_RECURSO,
                                                                                                                                FOJA_VUELTA,
                                                                                                                                ID_OFICINA,
                                                                                                                                ID_DOCUMENTO_ORIGEN,
                                                                                                                                EVENTOS,
                                                                                                                                ID_FIRMANTE_2,
                                                                                                                                INCORPORADO,
                                                                                                                                ID_ESTADO_EXPEDIENTE,
                                                                                                                                ID_EXPEDIENTE_ORIGEN,
                                                                                                                                ID_EXPEDIENTE_FUSION,
                                                                                                                                ID_CAMARA,
                                                                                                                                ID_DOCUMENTO_EXP_TMP,
                                                                                                                                ID_CEDULA_EXP_TMP,
                                                                                                                                ID_DOCUMENTO_BANDEJA_TMP,
                                                                                                                                ID_DOCUMENTO_REL_TMP,
                                                                                                                                SENTENCIA,
                                                                                                                                ID_RECURSO_EXP,
                                                                                                                                TIPO_PROYECTO,
                                                                                                                                TIMESTAMP_MODIFICACION,
                                                                                                                                USUARIO_MODIFICACION,
                                                                                                                                TICKET_DESPACHO_AVANZADO,
                                                                                                                                FECHA_ESTADO_DOCUMENTO,
                                                                                                                                INHIBIDO,
                                                                                                                                USUARIO_INHIBICION,
                                                                                                                                CREADO_MASIVO,
                                                                                                                                ID_SUBTIPO_FALLO,
                                                                                                                                CIERRA_RECURSO,
                                                                                                                                DIGITAL,
                                                                                                                                VERSION,
                                                                                                                                DESPACHO_DESDE_PDF,
                                                                                                                                ID_ESTADO_DOCUMENTO,
                                                                                                                                FECHA_INHIBICION,
                                                                                                                                CONTENT_TYPE)
        select S_AUDIT_DOCUMENTO_EXP.nextval, operacion, systimestamp, tabla, columna, tipoAccion, :new.ID_DOCUMENTO_EXP,
                                                                                                    :new.ID_EXPEDIENTE,
                                                                                                    :new.ID_MODELO,
                                                                                                    :new.ID_FIRMANTE,
                                                                                                    :new.ID_DOCUMENTO_RELACIONADO,
                                                                                                    :new.ID_CEDULA_EXP,
                                                                                                    :new.ID_DOCUMENTO_BANDEJA,
                                                                                                    :new.DESCRIPCION,
                                                                                                    :new.ORDEN,
                                                                                                    :new.FIRMA,
                                                                                                    :new.FECHA_FIRMA,
                                                                                                    :new.RESERVADO,
                                                                                                    :new.FOJAS,
                                                                                                    :new.FOJA_INICIAL,
                                                                                                    :new.CUERPO,
                                                                                                    :new.FECHA_GENERACION,
                                                                                                    :new.RESPONSABLE,
                                                                                                    :new.COMENTARIOS,
                                                                                                    :new.TIPO_DOCUMENTO,
                                                                                                    :new.ESTADO_EDICION,
                                                                                                    :new.USUARIO_EDICION,
                                                                                                    :new.FECHA_EDICION,
                                                                                                    :new.PROYECTO,
                                                                                                    :new.TIPO_RESOLUCION,
                                                                                                    :new.CERT_PRUEBA,
                                                                                                    :new.CERT_PRUEBA_DESCRIPCION,
                                                                                                    :new.TESTIMONIO,
                                                                                                    :new.ID_DOCUMENT_STORE,
                                                                                                    :new.STATUS,
                                                                                                    :new.UUID,
                                                                                                    :new.OBSERVACIONES_RES_RECURSO,
                                                                                                    :new.TIPO_VOTO_RES_RECURSO,
                                                                                                    :new.TIPO_RES_RECURSO,
                                                                                                    :new.FOJA_VUELTA,
                                                                                                    :new.ID_OFICINA,
                                                                                                    :new.ID_DOCUMENTO_ORIGEN,
                                                                                                    :new.EVENTOS,
                                                                                                    :new.ID_FIRMANTE_2,
                                                                                                    :new.INCORPORADO,
                                                                                                    :new.ID_ESTADO_EXPEDIENTE,
                                                                                                    :new.ID_EXPEDIENTE_ORIGEN,
                                                                                                    :new.ID_EXPEDIENTE_FUSION,
                                                                                                    :new.ID_CAMARA,
                                                                                                    :new.ID_DOCUMENTO_EXP_TMP,
                                                                                                    :new.ID_CEDULA_EXP_TMP,
                                                                                                    :new.ID_DOCUMENTO_BANDEJA_TMP,
                                                                                                    :new.ID_DOCUMENTO_REL_TMP,
                                                                                                    :new.SENTENCIA,
                                                                                                    :new.ID_RECURSO_EXP,
                                                                                                    :new.TIPO_PROYECTO,
                                                                                                    :new.TIMESTAMP_MODIFICACION,
                                                                                                    :new.USUARIO_MODIFICACION,
                                                                                                    :new.TICKET_DESPACHO_AVANZADO,
                                                                                                    :new.FECHA_ESTADO_DOCUMENTO,
                                                                                                    :new.INHIBIDO,
                                                                                                    :new.USUARIO_INHIBICION,
                                                                                                    :new.CREADO_MASIVO,
                                                                                                    :new.ID_SUBTIPO_FALLO,
                                                                                                    :new.CIERRA_RECURSO,
                                                                                                    :new.DIGITAL,
                                                                                                    :new.VERSION,
                                                                                                    :new.DESPACHO_DESDE_PDF,
                                                                                                    :new.ID_ESTADO_DOCUMENTO,
                                                                                                    :new.FECHA_INHIBICION,
                                                                                                    :new.CONTENT_TYPE
        from dual;
    end insertarNew;
begin
    -- Elijo la tabla que quiero auditar los cambios
    nombre_tabla_auditada := 'DOCUMENTO_EXP';

    select nvl(max(id_operacion), 0) + 1 into id_operacion
    from audit_documento_exp;

    --Select que busca en las tablas de sistema, la tabla elegida para obtener todas sus columnas.
    select *
    BULK COLLECT INTO var_columnas
    from user_tab_columns
    where upper(table_name) in (nombre_tabla_auditada);

    if inserting then -- Estoy haciendo un insert
            insertarNew('INSERCIÓN', nombre_tabla_auditada, null, id_operacion);
    elsif updating then
        -- La colección tiene todos los valores de la tabla auditada, en el campo column_name tengo el nombre de cada columna.
        for i in 1..var_columnas.count loop
            if updating(var_columnas(i).column_name) then
                insertarOld('ANTES DE ACTUALIZAR', var_columnas(i).table_name, var_columnas(i).column_name, id_operacion);
                insertarNew('DESPUÉS DE ACTUALIZAR', var_columnas(i).table_name, var_columnas(i).column_name, id_operacion);
            end if;
        end loop;
    end if;
exception
    when others then
        raise_application_error(-20028,SQLERRM);
end auditoria_firma;

/*
UPDATE "LEX100MAESTRAS"."AUDIT_DOCUMENTO_EXP2" SET ID_MODELO = '5', ID_DOCUMENTO_RELACIONADO = '5', ID_DOCUMENTO_BANDEJA = '1' WHERE ROWID = 'AAFGf4ABaAAGnVmAAA' AND ORA_ROWSCN = '350103015009'
ORA-20028: ORA-00904: "VAR_COLUMNAS": identificador no válido
ORA-06512: en "LEX100MAESTRAS.AUDITORIA_FIRMA", línea 27
ORA-04088: error durante la ejecución del disparador 'LEX100MAESTRAS.AUDITORIA_FIRMA'
CREATE SEQUENCE  "LEX100MAESTRAS"."s_audit_documento_exp"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE;
*/