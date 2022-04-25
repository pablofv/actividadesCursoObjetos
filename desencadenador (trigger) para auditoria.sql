CREATE OR REPLACE TRIGGER "LEX100MAESTRAS"."AUDITORIA_FIRMA" before insert or update
    on audit_documento_exp2 for each row
declare
    type columnas_tabla is table of user_tab_columns%ROWTYPE;
    var_columnas columnas_tabla := columnas_tabla();
    nombre_tabla_auditada varchar2(35);
begin
    -- Elijo la tabla que quiero auditar los cambios
    nombre_tabla_auditada := 'AUDIT_DOCUMENTO_EXP';

    --Select que busca en las tablas de sistema, la tabla elegida para obtener todas sus columnas.
    select *
    BULK COLLECT INTO var_columnas
    from user_tab_columns
    where upper(table_name) in (nombre_tabla_auditada);

    if inserting then -- Estoy haciendo un insert
            insert into audit_documento_exp(id_documento_exp, responsable) values (2, 'insert');
    elsif updating then
        -- La colección tiene todos los valores de la tabla auditada, en el campo column_name tengo el nombre de cada columna.
        for i in 1..var_columnas.count loop
            if updating(var_columnas(i).column_name) then
                execute immediate 'insert into cambioslex100auditoria(fechahora, tabla, campo, valoranterior, valoractual) values (systimestamp, var_columnas(i).table_name, var_columnas(i).column_name, :old.' || var_columnas(i).column_name || ', :new.' || var_columnas(i).column_name || ')';
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
*/