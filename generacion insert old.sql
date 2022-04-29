-- datos: nombre de tabla
-- datos: nombre de secuencia
-- objetivo: hacer una función que arme el select que debe ejecutarse en el trigger, con la variable old

create or replace function generoInsertOld(nombre_tabla varchar2, nombre_secuencia varchar2, nombre_tabla_auditoria varchar2) return varchar2 as
    --Variables tipo colección para guardar los campos de la tabla parámetro.
    type columnas_tabla is table of user_tab_columns%ROWTYPE;
    var_columnas columnas_tabla := columnas_tabla();
    var_sqlGenerado varchar2(10000);
    tabla varchar2(32);
    secuencia varchar2(32);
    tabla_auditoria varchar2(32);
begin
    tabla := upper(nombre_tabla);
    secuencia := upper(nombre_secuencia);
    tabla_auditoria := nombre_tabla_auditoria;
    --Select que busca en las tablas de sistema, la tabla elegida para obtener todas sus columnas.
    select *
    BULK COLLECT INTO var_columnas
    from user_tab_columns
    where upper(table_name) in (tabla);
    
    var_sqlGenerado := 'insert into '|| tabla_auditoria ||'(ID_AUDIT_DOCUMENTO_EXP, id_operacion, FECHAHORA, TABLADESDE, CAMPOMODIFICADO, tipoaccion';
    for i in 1 .. var_columnas.count loop
        var_sqlGenerado := var_sqlGenerado || ', ' || var_columnas(i).column_name;
    end loop;
    var_sqlgenerado := var_sqlgenerado || ') ';

    var_sqlGenerado := var_sqlGenerado || 'select ' || secuencia ||'.nextval, operacion, systimestamp, tabla, columna, tipoAccion';
    for i in 1 .. var_columnas.count loop
        var_sqlGenerado := var_sqlGenerado || ', ' || ':old.' ||var_columnas(i).column_name;
    end loop;
    var_sqlGenerado := var_sqlGenerado || ' from dual;';
    return var_sqlGenerado;
exception
    when others then
        raise_application_error(-20028,SQLERRM);
end generoInsertOld;
    