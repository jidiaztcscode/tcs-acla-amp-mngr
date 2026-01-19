package com.davivienda.pensionados.service;


import java.util.List;

import com.davivienda.pensionados.dto.PensionerAccountReportFilter;
import com.davivienda.pensionados.model.PensionerAccount;

public interface PensionerAccountService {
    List<PensionerAccount> getPensionerAccountReport(PensionerAccountReportFilter filter);
}