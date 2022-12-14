package sg.triquesta.model.dto.response.payment;

import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import sg.triquesta.model.entity.loan.LoanPayment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoanPaymentResponse {
    private String id;
    private BigDecimal paymentAmount;
    private Date paymentDate;

    public static LoanPaymentResponse fromLoanPayment(LoanPayment loanPayment){
        return LoanPaymentResponse.builder()
                .id(loanPayment.getId())
                .paymentAmount(loanPayment.getPaymentAmount())
                .paymentDate(loanPayment.getPaymentDate())
                .build();
    }

    public static List<LoanPaymentResponse> fromLoans(List<LoanPayment> loanPayments){
        if(CollectionUtils.isEmpty(loanPayments)){
            return new ArrayList<>();
        }

        return loanPayments.stream().map(LoanPaymentResponse::fromLoanPayment)
                .collect(Collectors.toList());
    }
}
