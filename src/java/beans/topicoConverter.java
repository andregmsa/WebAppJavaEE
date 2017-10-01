/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.TopicoController;
import entities.Topico;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author andre
 */

@FacesConverter(value = "topicoConverter")
public class topicoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String topicoId) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{topicoController}", TopicoController.class);

        TopicoController topicos = (TopicoController)vex.getValue(ctx.getELContext());
        return topicos.getTopico(Integer.valueOf(topicoId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object topico) {
        return ((Topico)topico).getTopicoId().toString();
    }

}