package com.patika.business.concretes;

import com.patika.business.abstracts.MemberAccountService;
import com.patika.business.requests.MemberAccountRequest;
import com.patika.business.responses.MemberAccountResponse;
import com.patika.dataAccess.MemberAccountRepository;
import com.patika.entity.MemberAccount;
import com.patika.utilities.mappers.ModelMapperService;
import com.patika.utilities.results.DataResult;
import com.patika.utilities.results.ErrorDataResult;
import com.patika.utilities.results.Result;
import com.patika.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberAccountManager implements MemberAccountService {

    MemberAccountRepository _memberAccountRepository;
    ModelMapperService _modelMapperService;

    @Autowired
    public MemberAccountManager(MemberAccountRepository _memberAccountRepository, ModelMapperService _modelMapperService) {
        this._memberAccountRepository = _memberAccountRepository;
        this._modelMapperService = _modelMapperService;
    }

    @Override
    public DataResult<MemberAccountRequest> add(MemberAccountRequest memberAccountRequest) {
        try {
            MemberAccount memberAccount = this._modelMapperService.forRequest().map(memberAccountRequest, MemberAccount.class);
            this._memberAccountRepository.save(memberAccount);
            memberAccountRequest=this._modelMapperService.forRequest().map(memberAccount, MemberAccountRequest.class);
            memberAccount.setMemberCode(memberAccountRequest.getId()+memberAccountRequest.getName().substring(0,2));
            MemberAccount newMemberAccount=this._modelMapperService.forRequest().map(memberAccount,MemberAccount.class);
            this._memberAccountRepository.save(newMemberAccount);
            memberAccountRequest=this._modelMapperService.forRequest().map(newMemberAccount, MemberAccountRequest.class);
            return new SuccessDataResult<>(memberAccountRequest, "Success");
        }catch (Exception error){
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<MemberAccountRequest> update(MemberAccountRequest memberAccountRequest) {
        return null;
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<MemberAccountResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<MemberAccountResponse> getById(Integer id) {
        return null;
    }
}
