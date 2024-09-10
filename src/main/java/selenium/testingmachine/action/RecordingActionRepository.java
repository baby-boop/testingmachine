package selenium.testingmachine.action;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingActionRepository extends JpaRepository<RecordingAction, Long> {

}
//Энэхүү код нь дуудсан сайт дээрх хийсэн үйлдлүүдээ бүртгэлжүүлэхгүй байгаа бөгөөд Browser quit, Quitting the browser энэ үйлдлүүдийг л хадгалаж байна. Бусад үйлдлийг хадгаладаг болгох хийсэн үйлдлүүдийг дарааллаар нь json хэлбэртэй хадгалж дуусгах үед тухайн хийсэн үйлдүүд дээрээ нэр өгж хадгалдаг болгох ба хадгалсан үйлдүүдийг жагсаалтаар харуулах