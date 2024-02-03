import { useEffect } from "react";
/**
 * 컴포넌트 밖의 외부 DOM요소를 클릭 시 해당 컴포넌트의 특정 props를 변경합니다.
 * 사용법은 다음 예시와 같습니다.
 * ```
 * const closeMenu = useCallback(() => {
    if (open) setOpen(false);
  }, [open]);

  useOutsideClick(ref, closeMenu);
 * ```
 * @param {*} ref - useRef.current로 최근 선택된 DOM요소를 확인합니다.
 * @param {*} callback - 콜백 함수는 컴포넌트의 특정 props를 변경합니다. useCallback을 사용하여 리렌더링을 방지할 수 있습니다.
 */
const useOutsideClick = (ref, callback) => {
  useEffect(() => {
    const handleClickOutside = (event) => {
      if (ref.current && !ref.current.contains(event.target)) {
        callback();
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [ref, callback]);
};

export default useOutsideClick;
