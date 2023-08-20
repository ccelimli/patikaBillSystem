package com.patika.business.abstracts;

import com.patika.business.requests.MemberAccountRequest;
import com.patika.business.responses.MemberAccountResponse;
import com.patika.utilities.results.DataResult;
import com.patika.utilities.results.Result;

import java.util.List;

public interface MemberAccountService {
    DataResult<MemberAccountRequest> add(MemberAccountRequest memberAccountRequest);
    DataResult<MemberAccountRequest> update(MemberAccountRequest memberAccountRequest);
    Result delete(Integer id);
    DataResult<List<MemberAccountResponse>> getAll();
    DataResult<MemberAccountResponse> getById(Integer id);

}
