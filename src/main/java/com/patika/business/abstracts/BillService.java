package com.patika.business.abstracts;



import com.patika.business.requests.BillRequest;
import com.patika.business.responses.BillResponse;
import com.patika.entity.Bill;
import com.patika.utilities.results.DataResult;
import com.patika.utilities.results.Result;

import java.util.List;

public interface BillService {
    DataResult<BillRequest> add(BillRequest billRequest);
    DataResult<BillRequest> update(BillRequest billRequest);
    Result delete(Integer id);
    DataResult<List<BillResponse>> getAll();
    DataResult<BillResponse> getById(Integer id);
    DataResult<BillResponse> getByCode(Integer id);
    DataResult<BillResponse> payBill(Integer id);
    DataResult<BillResponse> cancelBill(Integer id);
}
