package com.patika.business.concretes;

import com.patika.business.abstracts.BillService;
import com.patika.business.requests.BillRequest;
import com.patika.business.responses.BillResponse;
import com.patika.dataAccess.BillRepository;
import com.patika.dataAccess.MemberAccountRepository;
import com.patika.entity.Bill;
import com.patika.entity.MemberAccount;
import com.patika.utilities.mappers.ModelMapperService;
import com.patika.utilities.results.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillManager implements BillService {
    private BillRepository _billRepository;
    private MemberAccountRepository _memberAccountRepository;
    private ModelMapperService _modelMapperService;

    public BillManager(BillRepository billRepository, ModelMapperService modelMapperService, MemberAccountRepository _memberAccountRepository) {
        this._memberAccountRepository=_memberAccountRepository;
        this._billRepository = billRepository;
        this._modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<BillRequest> add(BillRequest billRequest) {
        try {
            Bill bill = this._modelMapperService.forRequest().map(billRequest, Bill.class);
            bill.setIsPayment(false);
            this._billRepository.save(bill);
            billRequest = this._modelMapperService.forRequest().map(bill, BillRequest.class);
            return new SuccessDataResult<>(billRequest, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<BillRequest> update(BillRequest billRequest) {
        try {
            Bill bill = this._modelMapperService.forRequest().map(billRequest, Bill.class);
            this._billRepository.save(bill);
            billRequest = this._modelMapperService.forRequest().map(bill, BillRequest.class);
            return new SuccessDataResult<>(billRequest, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public Result delete(Integer id) {
        try {
            this._billRepository.deleteById(id);
            return new SuccessDataResult<>("Success");
        } catch (Exception error) {
            return new ErrorResult(error.getMessage());
        }
    }

    @Override
    public DataResult<List<BillResponse>> getAll() {
        try {
            List<Bill> billList = this._billRepository.findAll();
            List<BillResponse> billResponseList = billList.stream().map(otgAracSahibi -> this._modelMapperService.forResponse().map(otgAracSahibi, BillResponse.class)).collect(Collectors.toList());
            return new SuccessDataResult<>(billResponseList, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<BillResponse> getById(Integer id) {
        try {
            Bill bill = this._billRepository.findById(id).orElseThrow();
            BillResponse billResponse = this._modelMapperService.forResponse().map(bill, BillResponse.class);
            return new SuccessDataResult<>(billResponse, "Success");
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }

    @Override
    public DataResult<BillResponse> getByCode(Integer id) {
        MemberAccount memberAccount=this._memberAccountRepository.findById(id).orElseThrow();
        String code=memberAccount.getMemberCode();
        Bill findBill = this._billRepository.getByCode(code);
        BillResponse billResponse = this._modelMapperService.forResponse().map(findBill, BillResponse.class);
        return new SuccessDataResult<>(billResponse, "Success");
    }

    @Override
    public DataResult<BillResponse> payBill(Integer id) {
        try {
            Bill bill = this._billRepository.findById(id).orElseThrow();
            if (bill.getMemberAccount().getBalance() < bill.getAmount()) {
                return new ErrorDataResult<>("İşlem Başarısız! Bakiye Yetersiz!");
            } else {
                bill.getMemberAccount().setBalance(bill.getMemberAccount().getBalance() - bill.getAmount());
                bill.setIsPayment(true);
                this._billRepository.save(bill);
                BillResponse billResponse = this._modelMapperService.forResponse().map(bill, BillResponse.class);
                return new SuccessDataResult<>(billResponse, "Success");
            }
        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }

    }

    @Override
    public DataResult<BillResponse> cancelBill(Integer id) {
        try {
            Bill bill = this._billRepository.findById(id).orElseThrow();
            bill.getMemberAccount().setBalance(bill.getMemberAccount().getBalance() + bill.getAmount());
            bill.setIsPayment(false);
            this._billRepository.save(bill);
            BillResponse billResponse = this._modelMapperService.forResponse().map(bill, BillResponse.class);
            return new SuccessDataResult<>(billResponse, "Success");

        } catch (Exception error) {
            return new ErrorDataResult<>(error.getMessage());
        }
    }
}
