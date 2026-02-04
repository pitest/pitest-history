package org.pitest.mutationtest.incremental;

import org.junit.Test;
import org.mockito.Mockito;
import org.pitest.mutationtest.*;
import org.pitest.mutationtest.report.MutationTestResultMother;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class HistoryResultInterceptorTest {
    private History store = Mockito.mock(History.class);
    private HistoryResultInterceptor testee = new HistoryResultInterceptor(this.store);

    @Test
    public void recordsMutationResults() {
        final MutationResult mr = makeResult();
        final ClassMutationResults metaData = MutationTestResultMother
                .createClassResults(mr);
        Collection<ClassMutationResults> mutants = asList(metaData);
        Collection<ClassMutationResults> actual = this.testee.modify(mutants);
        verify(this.store).recordResult(mr);
        assertThat(actual).isSameAs(mutants);
    }


    private MutationResult makeResult() {
        return new MutationResult(
                MutationTestResultMother.createDetails(), MutationStatusTestPair.notAnalysed(0,
                DetectionStatus.KILLED));
    }

}