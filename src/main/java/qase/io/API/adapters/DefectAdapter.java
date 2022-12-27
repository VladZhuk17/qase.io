package qase.io.API.adapters;


import io.restassured.response.Response;
import qase.io.API.models.Defect;

import static qase.io.API.util.StringConstant.GET_SPECIFIC_DEFECT_API_ENDPOINT;
import static qase.io.API.util.StringConstant.GET_ALL_DEFECTS_API_ENDPOINT;

public class DefectAdapter extends BaseAdapter{

    public Response getAllDefects(String projectCode){
        return get(String.format(GET_ALL_DEFECTS_API_ENDPOINT, projectCode));
    }

    public Response createDefect (String projectCode, Defect defect){
        return post(String.format(GET_ALL_DEFECTS_API_ENDPOINT, projectCode),converter.toJson(defect));
    }

    public Response deleteDefect (String projectCode, Defect defect){
        return delete(String.format(GET_SPECIFIC_DEFECT_API_ENDPOINT, projectCode,defect.getId()));
    }

    public Response getSpecificDefect(String projectCode, Defect defect){
        return get(String.format(GET_SPECIFIC_DEFECT_API_ENDPOINT,projectCode,defect.getId()));
    }

    public Response updateDefect (String projectCode, Defect defect){
        return post(String.format(GET_ALL_DEFECTS_API_ENDPOINT, projectCode),converter.toJson(defect));
    }

}
